package cz.czechitas.java.database;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SpousteciTrida {

    public static void main(String[] args) throws SQLException, InterruptedException {
        MariaDbDataSource konfiguraceDatabaze = new MariaDbDataSource();
        konfiguraceDatabaze.setUrl("jdbc:mysql://localhost:3306/DailyPlanetMartina");
        konfiguraceDatabaze.setUserName("student");
        konfiguraceDatabaze.setPassword("password");

        JdbcTemplate odesilacDotazu = new JdbcTemplate(konfiguraceDatabaze);

        System.out.println("Vítejte v konzolové databázové hře. Uvidíte tabulky z databáze Daily Planet.");

        ResultSetExtractor<Collection<Clanek>> prevodnikClankuSAutory = new PrevodnikClankuSAutory();
        Collection<Clanek> clanky1 = odesilacDotazu.query("" +
            "select clanky.idClanku as idClanku, clanky.nazev as nazev, clanky.datum as datum, " +
            "       zamestnanci.idAutor as autorId, zamestnanci.jmeno as jmeno, zamestnanci.bydliste as bydliste, zamestnanci.plat, zamestnanci.datumNastupu " +
            "  from clanky join zamestnanci on clanky.idAutor=zamestnanci.idAutor", prevodnikClankuSAutory);
        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("1. Seznam všech článků Daily Planet:");
        System.out.println();
        for (Clanek clanek : clanky1) {
            System.out.println(clanek.clankySIdPodleAutora());
        }

        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("2. Seznam všech článků Daily Planet s datem nástupu redaktorů:");
        System.out.println();
        for (Clanek clanek : clanky1) {
            System.out.println("Název článku: " + clanek.getNazev() + " od " + clanek.getAutor().getJmeno() + " v Dialy Planet od: " + clanek.getAutor().getDatumNastupu());
        }

        //získej počet článků:
        Long pocetClanku = odesilacDotazu.queryForObject("select count (*) from clanky", Long.class);
        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("3. V databázi je " + pocetClanku + " článků");

        RowMapper<Zamestnanec> prevodnikZamci;
        System.out.println();
        prevodnikZamci = BeanPropertyRowMapper.newInstance(Zamestnanec.class);
        List<Zamestnanec> zamci = odesilacDotazu.query("select * from zamestnanci", prevodnikZamci);
        //vypíše seznam všech zaměstnanců
        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("4. Seznam zaměstnanců daily Planet:");
        System.out.println();
        for (Zamestnanec z : zamci) {
            System.out.println(z.zamestnanciPrint());
        }

        //vypsat články autora podle id:
        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("5. Zadejte ID zaměstnance a stiskněte enter, vypíšeme její/jeho články, zaměstnanci jsou 4:");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        Long kodZamestnanec = sc.nextLong();

        if (kodZamestnanec < 5) {
            String hledany_autor = odesilacDotazu.queryForObject("select distinct Autor from clanky where idAutor=?", String.class, kodZamestnanec);
            System.out.println();
            System.out.println("*************************************************************************");
            System.out.println("6. Seznam článků autora " + hledany_autor + ":");
            System.out.println();

            for (Clanek c : clanky1) {
                if (c.getAutor().getId() == kodZamestnanec) {
                    System.out.println(c.clankyBezAutora());
                }
            }
        } else {
            System.out.println("Nezadali jste správný kód zaměstnance, program pokračuje");
        }


        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("7. Teď program vypíše tabulku s počty článků podle autorů");
        System.out.println();
        RowMapper<PocetClanku> prevodnikClankyProdej;
        prevodnikClankyProdej = BeanPropertyRowMapper.newInstance(PocetClanku.class);
        //vypiš prodaný náklad podle dnů v týdnu:
        List<PocetClanku> clankyProdej = odesilacDotazu.query("select autor, count(nazev) as pocetClanku from clanky group by autor order by count(nazev) desc;", prevodnikClankyProdej);
        for (PocetClanku cl : clankyProdej) {
            System.out.println(cl);
        }

        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("8. Zkuste hádat, ve který den v týdnu v únoru 2019 se Daily Planet nejlépe prodával, napište pondělí, úterý, " +
            "středa, čtvrtek nebo pátek a stiskněte enter");
        System.out.println();
        String tipDenVTydnu = sc.next();
        sc.nextLine();


        //průměrný prodaný náklad podle dne v týdnu:
        RowMapper<Naklad> prevodnikNaklad;
        prevodnikNaklad = BeanPropertyRowMapper.newInstance(Naklad.class);
        String topDenVTydnu = odesilacDotazu.queryForObject("select denVTydnu from prodanyNaklad  group by denVTydnu Order by AVG(prodanyNaklad) desc limit 1;", String.class);

        if (topDenVTydnu.equals(tipDenVTydnu)) {
            System.out.println("Správně, " + topDenVTydnu + " je den v týdnu, kdy se prodalo nejvíc novin Daily Planet");
        } else {
            System.out.println("Ne, " + tipDenVTydnu + " není den, kdy se prodalo nejvíc novin Daily Planet, je to " + topDenVTydnu + ".");
        }

        //vypiš prodaný náklad podle dnů v týdnu:
        List<Naklad> prodanyNaklad = odesilacDotazu.query("select denVTydnu, avg(prodanyNaklad) as prumernyProdanyNaklad from prodanyNaklad  group by denVTydnu Order by SUM(zisk) desc;", prevodnikNaklad);
        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("9. Dny v týdnu podle průměrného prodaného nákladu:");
        System.out.println();
        for (Naklad n : prodanyNaklad) {
            System.out.println(n);
        }

        //JOIN TABULEK:
        RowMapper<ClankyProdej> prevodnikClanekProdej;
        prevodnikClanekProdej = BeanPropertyRowMapper.newInstance(ClankyProdej.class);
        //vypiš prodaný náklad podle dnů v týdnu:
        List<ClankyProdej> joinClankyProdej = odesilacDotazu.query("select clanky.nazev as nazev, clanky.autor as autor, clanky.datum as datum, prodanyNaklad.prodanyNaklad as prodanyNaklad from clanky join prodanyNaklad on clanky.datum=prodanyNaklad.datum order by prodanyNaklad desc;", prevodnikClanekProdej);
        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("10. Join: pořadí prodejnosti novin daily Planet podle uveřejněného článku");
        System.out.println();
        for (ClankyProdej cp : joinClankyProdej) {
            System.out.println(cp);
        }

        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("11. Lois Lane potřebuje pomoci s názvem článku o brněnské ZOO, napište název a stiskněte enter");
        System.out.println();
        String novyNazevClanku = sc.nextLine();
        System.out.println("nový název článku je: " + novyNazevClanku);

        odesilacDotazu.update("INSERT INTO clanky (nazev, autor, idAutor, datum) VALUES (?, 'Loise Lane', 1, '2019-02-3')", novyNazevClanku);

        Collection<Clanek> clanky2 = odesilacDotazu.query("" +
            "select clanky.idClanku as idClanku, clanky.nazev as nazev, clanky.datum as datum, " +
            "       zamestnanci.idAutor as autorId, zamestnanci.jmeno as jmeno, zamestnanci.bydliste as bydliste, zamestnanci.plat, zamestnanci.datumNastupu " +
            "  from clanky join zamestnanci on clanky.idAutor=zamestnanci.idAutor", prevodnikClankuSAutory);

        System.out.println();
        for (Clanek clanek : clanky2) {
            System.out.println("Id: " + clanek.getId() + ", autor: " + clanek.getAutor().getJmeno() + ", název: " + clanek.getNazev());
        }

        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("12. Napište číslo článku, který chcete smazat a stiskněte enter, článků je celkem " + pocetClanku);
        System.out.println();
        Long clanekNaSmazani = sc.nextLong();

        for (Clanek d : clanky2) {
            if (d.getId() == clanekNaSmazani) {
                System.out.println("Mažete článek:");
                System.out.println(d.clankySIdPodleAutora());
                odesilacDotazu.update("delete from clanky where idClanku=?", clanekNaSmazani);
                Thread.sleep(2000);
                System.out.println("Smazali jste celou databázi, ajajaj");
                Thread.sleep(3000);
                System.out.println();
                System.out.println("To byl jen vtip");

                Collection<Clanek> clanky3 = odesilacDotazu.query("" +
                    "select clanky.idClanku as idClanku, clanky.nazev as nazev, clanky.datum as datum, " +
                    "       zamestnanci.idAutor as autorId, zamestnanci.jmeno as jmeno, zamestnanci.bydliste as bydliste, zamestnanci.plat, zamestnanci.datumNastupu " +
                    "  from clanky join zamestnanci on clanky.idAutor=zamestnanci.idAutor", prevodnikClankuSAutory);

                System.out.println();

                System.out.println();
                for (Clanek clanek : clanky3) {
                    clanek.clankySIdPodleAutora();
                }

                Long pocetClanku3 = odesilacDotazu.queryForObject("select count (*) from clanky", Long.class);
                System.out.println();
                System.out.println("V databázi je " + pocetClanku3 + " článků");
                return;
            }
        }
        System.out.println("Zadaný článek v databázi neexistuje");

    }
}

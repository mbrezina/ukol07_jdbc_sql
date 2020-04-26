package cz.czechitas.java.database;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.Collection;

import java.sql.SQLException;

public class SpousteciTrida {

    public static void main(String[] args) throws SQLException {
        MariaDbDataSource konfiguraceDatabaze = new MariaDbDataSource();
        konfiguraceDatabaze.setUrl("jdbc:mysql://localhost:3306/DailyPlanetMartina");
        konfiguraceDatabaze.setUserName("student");
        konfiguraceDatabaze.setPassword("password");

        JdbcTemplate odesilacDotazu = new JdbcTemplate(konfiguraceDatabaze);

/*
        RowMapper<Clanek> prevodnikClanky;
        prevodnikClanky = BeanPropertyRowMapper.newInstance(Clanek.class);
        //získej a vypiš všechny články
        List<Clanek> clanky = odesilacDotazu.query("select * from Clanky", prevodnikClanky);
        System.out.println("*************************************************************************");
        System.out.println();
        System.out.println("Seznam všech článků Daily Planet:");
        System.out.println();
        for (Clanek c : clanky) {
            System.out.println(c);
        }
        //získej počet článků:
        Long pocetClanku = odesilacDotazu.queryForObject("select count (*) from Clanky", Long.class);

        System.out.println("V databázi je " + pocetClanku + " článků");

        RowMapper<Zamestnanec> prevodnikZamci;
        prevodnikZamci = BeanPropertyRowMapper.newInstance(Zamestnanec.class);
        List<Zamestnanec> zamci = odesilacDotazu.query("select * from Zamestnanci", prevodnikZamci);
        //vypíše seznam všech zaměstnanců
        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("Seznam zaměstnanců daily Planet:");
        System.out.println();
        for (Zamestnanec z : zamci) {
            System.out.println(z);
        }

        //vypsat články autora podle id:
        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("Zadejte ID zaměstnance a stiskněte enter, vypíšeme její/jeho články:");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        Long kod_zamestnanec = sc.nextLong();

        List<Clanek> clanky_autora = odesilacDotazu.query("select * from Clanky where id_autor=?", prevodnikClanky, kod_zamestnanec);

        String hledany_autor = odesilacDotazu.queryForObject("select distinct Autor from Clanky where id_autor=?", String.class, kod_zamestnanec);
        System.out.println();
        System.out.println("Seznam článků autora " + hledany_autor + ":");
        System.out.println();
        for (Clanek c : clanky_autora) {
            System.out.println(c);
        }

        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("Teď program vypíše tabulku s počty článků podle autorů");
        System.out.println();
        RowMapper<PocetClanku> prevodnikClankyProdej;
        prevodnikClankyProdej = BeanPropertyRowMapper.newInstance(PocetClanku.class);
        //vypiš prodaný náklad podle dnů v týdnu:
        List<PocetClanku> clankyProdej = odesilacDotazu.query("select autor, count(nazev) as pocetClanku from Clanky group by autor order by count(nazev) desc;", prevodnikClankyProdej);
        for (PocetClanku cl : clankyProdej) {
            System.out.println(cl);
        }


        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("Zkuste hádat, ve který den v týdnu v únoru 2019 se Daily Planet nejlépe prodával, napište pondělí, úterý, " +
            "středa, čtvrtek nebo pátek a stiskněte enter");
        System.out.println();
        Scanner sc2 = new Scanner(System.in);
        String tip_den_tydnu = sc2.next();

        //   průměrný prodaný náklad podle dne v týdnu:
        RowMapper<Naklad> prevodnikNaklad;
        prevodnikNaklad = BeanPropertyRowMapper.newInstance(Naklad.class);
        //vypiš prodaný náklad podle dnů v týdnu:
        List<Naklad> prodany_naklad = odesilacDotazu.query("select Den_v_Tydnu, avg(Prodany_naklad) as prumerny_prodany_naklad from Prodany_naklad  group by Den_v_tydnu Order by SUM(Zisk) desc;", prevodnikNaklad);
        System.out.println();
        System.out.println("Dny v týdnu podle průměrného prodaného nákladu:");
        System.out.println();
        for (Naklad n : prodany_naklad) {
            System.out.println(n);
        }

        //   JOIN TABULEK:
        RowMapper<ClankyProdej> prevodnikClanekProdej;
        prevodnikClanekProdej = BeanPropertyRowMapper.newInstance(ClankyProdej.class);
        //vypiš prodaný náklad podle dnů v týdnu:
        List<ClankyProdej> joinClankyProdej = odesilacDotazu.query("select Clanky.Nazev as nazev, Clanky.autor as autor, Clanky.datum as datum, Prodany_naklad.prodany_naklad as prodanyNaklad from Clanky join Prodany_naklad on Clanky.Datum=Prodany_naklad.Datum order by prodany_naklad desc;", prevodnikClanekProdej);
        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("Join: pořadí prodejnosti novin daily Planet podle uveřejněného článku");
        System.out.println();
        for (ClankyProdej cp : joinClankyProdej) {
            System.out.println(cp);
        }
*/

        ResultSetExtractor<Collection<Clanek>> prevodnikClankuSAutory = new PrevodnikClankuSAutory();
        Collection<Clanek> clanky = odesilacDotazu.query("" +
                "select clanky.idClanku as idClanku, clanky.nazev as nazev, clanky.datum as datum, " +
                "       zamestnanci.idAutor as autor_id, zamestnanci.jmeno as jmeno, zamestnanci.bydliste as bydliste, zamestnanci.plat, zamestnanci.datumNastupu " +
                "  from clanky join zamestnanci on clanky.idAutor=zamestnanci.idAutor", prevodnikClankuSAutory);


        for (Clanek clanek : clanky) {

            System.out.println(clanek);

        }
    }

}

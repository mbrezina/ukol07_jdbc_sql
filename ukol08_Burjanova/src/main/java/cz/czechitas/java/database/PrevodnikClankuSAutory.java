package cz.czechitas.java.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class PrevodnikClankuSAutory implements ResultSetExtractor<Collection<Clanek>> {

    @Override
    public Collection<Clanek> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Clanek> clanky = new TreeMap<>();
        Map<Long, Zamestnanec> zamestnanci = new HashMap<>();
        RowMapper<Clanek> clanekRowMapper = BeanPropertyRowMapper.newInstance(Clanek.class);
        RowMapper<Zamestnanec> zamestnanecRowMapper = BeanPropertyRowMapper.newInstance(Zamestnanec.class);
        int rowNum = 0;
        while (rs.next()) {
            rowNum++;

            Long clanekId = rs.getLong("id_clanku");
            Clanek clanek = register(clanky, clanekId, clanekRowMapper.mapRow(rs, rowNum));
            clanek.setId(clanekId);      // doplni vlastnosti, ktere se rowMapperu nepodarilo namapovat

            Long autorId = rs.getLong("autor_id");
            Zamestnanec autor = register(zamestnanci, autorId, zamestnanecRowMapper.mapRow(rs, rowNum));
            autor.setId(autorId);       // doplni vlastnosti, ktere se rowMapperu nepodarilo namapovat

            clanek.setAutor(autor);
        }
        return clanky.values();
    }

    private <KEY, ENTITY> ENTITY register(Map<KEY, ENTITY> existujiciEntity, KEY id, ENTITY entita) {
        ENTITY nalezenaEntita = existujiciEntity.get(id);
        if (nalezenaEntita != null) {
            return nalezenaEntita;
        } else {
            existujiciEntity.put(id, entita);
            return entita;
        }
    }
}

package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.converter;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoAtendimento;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoAtendimentoConverter implements AttributeConverter<TipoAtendimento, String> {


    @Override
    public String convertToDatabaseColumn(TipoAtendimento tipoAtendimento) {
        if (tipoAtendimento == null) {
            return null;
        }
        return tipoAtendimento.name();
    }

    @Override
    public TipoAtendimento convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return TipoAtendimento.valueOf(dbData);
    }
}

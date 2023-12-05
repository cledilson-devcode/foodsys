package com.cledilsondevcode.foodsys.api.model;

import com.cledilsondevcode.foodsys.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
import java.util.Objects;

@JacksonXmlRootElement(localName = "cozinhas")
public class CozinhasXmlWrapper {

    @JsonProperty("cozinhas")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Cozinha> cozinhas;

    public CozinhasXmlWrapper(List<Cozinha> cozinhas) {
        this.cozinhas = cozinhas;
    }

    public List<Cozinha> getCozinhas() {
        return cozinhas;
    }

    public void setCozinhas(List<Cozinha> cozinhas) {
        this.cozinhas = cozinhas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CozinhasXmlWrapper that = (CozinhasXmlWrapper) o;
        return Objects.equals(cozinhas, that.cozinhas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cozinhas);
    }
}

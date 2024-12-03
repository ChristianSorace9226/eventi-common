package it.nsa.common.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class GenericResponse {
    private String status;
    private Long idUtente;
    private List<String> errors;

    public GenericResponse(String status, Long idUtente, List<String> errors) {
        this.status = status;
        this.idUtente = idUtente;
        this.errors = errors;
    }

    public static GenericResponse success(String status, Long idUtente) {
        return new GenericResponse(status, idUtente, new ArrayList<>());
    }

    public static GenericResponse error(String status, List<String> errors) {
        return new GenericResponse(status, null, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericResponse that = (GenericResponse) o;
        return Objects.equals(status, that.status) && Objects.equals(idUtente, that.idUtente) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, idUtente, errors);
    }

    @Override
    public String
    toString() {
        final StringBuffer sb = new StringBuffer("GenericResponse{");
        sb.append("errors=").append(errors);
        sb.append(", status='").append(status).append('\'');
        sb.append(", idUtente=").append(idUtente);
        sb.append('}');
        return sb.toString();
    }
}

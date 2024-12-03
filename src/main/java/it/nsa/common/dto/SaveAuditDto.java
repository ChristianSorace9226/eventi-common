package it.nsa.common.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SaveAuditDto<T> extends OperationOutcomeTypeDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1315517424988736002L;

    protected T requestJson;
    protected String errorMessage;
    protected LocalDateTime operationTime;

    public SaveAuditDto(Byte operationOutcome, String operationType, String errorMessage, LocalDateTime operationTime, T requestJson) {
        super(operationOutcome, operationType);
        this.errorMessage = errorMessage;
        this.operationTime = operationTime;
        this.requestJson = requestJson;
    }

    // Metodi di costruzione rapida
    public static <T> SaveAuditDto<T> success(String operationType, T requestJson) {
        return new SaveAuditDto<>(
                Byte.valueOf("1"),
                operationType,
                null,
                LocalDateTime.now(),
                requestJson
        );
    }

    public static <T> SaveAuditDto<T> processing(String operationType, T requestJson) {
        return new SaveAuditDto<>(
                Byte.valueOf("0"),
                operationType,
                null,
                LocalDateTime.now(),
                requestJson
        );
    }

    public static <T> SaveAuditDto<T> error(String operationType, String errorMessage, T requestJson) {
        return new SaveAuditDto<>(
                Byte.valueOf("-1"),
                operationType,
                errorMessage,
                LocalDateTime.now(),
                requestJson
        );
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SaveAuditDto{");
        sb.append("errorMessage='").append(errorMessage).append('\'');
        sb.append(", requestJson=").append(requestJson);
        sb.append(", operationTime=").append(operationTime);
        sb.append(", operationOutcome=").append(operationOutcome);
        sb.append(", operationType='").append(operationType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

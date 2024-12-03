package it.nsa.common.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OperationOutcomeTypeDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1315517424988736002L;

    protected Byte operationOutcome;
    protected String operationType;

    public OperationOutcomeTypeDto(Byte operationOutcome, String operationType) {
        this.operationOutcome = operationOutcome;
        this.operationType = operationType;
    }

}
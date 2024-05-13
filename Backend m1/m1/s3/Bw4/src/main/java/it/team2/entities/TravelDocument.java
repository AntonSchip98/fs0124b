package it.team2.entities;

import it.team2.services.TicketCodeGeneratorService;
import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "ticket_type", discriminatorType = DiscriminatorType.STRING)
public abstract class TravelDocument extends BaseEntity {
    @Column(name = "ticket_code", nullable = false, unique = true)
    private String code;

    @Column(name = "issuing_point_id")
    private Long issuingPoint;

    public TravelDocument() {
    }

    public TravelDocument(Long issuingPoint) {
        TicketCodeGeneratorService codeGeneratorService = new TicketCodeGeneratorService();
        this.code = codeGeneratorService.generateTicketCode();
        this.issuingPoint = issuingPoint;
    }

    public String getCode() {
        return code;
    }

    public Long getIssuingPoint() {
        return issuingPoint;
    }

    public void setIssuingPoint(Long issuingPoint) {
        this.issuingPoint = issuingPoint;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TravelDocument.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("issuingPoint='" + issuingPoint + "'")
                .toString();
    }
}

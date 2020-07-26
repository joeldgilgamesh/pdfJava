package Manage;

import java.util.Objects;

public class ImputationDTO {


    private Long id;

    private Long numDeclarationImputation;

    private String operation;

    private String natrureDesDroits;

    private Double montant;


    private Long justificatifPaiementId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumDeclarationImputation() {
        return numDeclarationImputation;
    }

    public void setNumDeclarationImputation(Long numDeclarationImputation) {
        this.numDeclarationImputation = numDeclarationImputation;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getNatrureDesDroits() {
        return natrureDesDroits;
    }

    public void setNatrureDesDroits(String natrureDesDroits) {
        this.natrureDesDroits = natrureDesDroits;
    }

    public Double getMontant() {

        return montant;
    }

    public void setMontant(Double montant) {
        Double montantArrondi= Math.ceil(montant);
        this.montant = montantArrondi;
    }

    public Long getJustificatifPaiementId() {
        return justificatifPaiementId;
    }

    public void setJustificatifPaiementId(Long justificatifPaiementId) {
        this.justificatifPaiementId = justificatifPaiementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ImputationDTO imputationDTO = (ImputationDTO) o;
        if (imputationDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), imputationDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ImputationDTO{" +
                "id=" + getId() +
                ", numDeclarationImputation=" + getNumDeclarationImputation() +
                ", operation='" + getOperation() + "'" +
                ", natrureDesDroits='" + getNatrureDesDroits() + "'" +
                ", montant=" + getMontant() +
                ", justificatifPaiementId=" + getJustificatifPaiementId() +
                "}";
    }
}

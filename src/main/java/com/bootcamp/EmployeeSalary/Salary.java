package com.bootcamp.EmployeeSalary;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Salary {
    @Column(name = "basicSalary")
    private Double basicSalary;
    @Column(name = "bonusSalary")
    private Double bonusSalary;
    @Column(name = "taxAmount")
    private Double taxAmount;
    @Column(name = "specialAllowanceSalary")
    private Double specialAllowanceSalary;

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(Double bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getSpecialAllowanceSalary() {
        return specialAllowanceSalary;
    }

    public void setSpecialAllowanceSalary(Double specialAllowanceSalary) {
        this.specialAllowanceSalary = specialAllowanceSalary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "basicSalary=" + basicSalary +
                ", bonusSalary=" + bonusSalary +
                ", taxAmount=" + taxAmount +
                ", specialAllowanceSalary=" + specialAllowanceSalary +
                '}';
    }
}

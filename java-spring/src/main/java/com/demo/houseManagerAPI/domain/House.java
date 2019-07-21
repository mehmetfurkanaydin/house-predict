package com.demo.houseManagerAPI.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "house_prices")
public class House {

    @Id
    String id;
    Number CRIM;
    Number ZN;
    Number INDUS;
    Number CHAS;
    Number NOX;
    Number RM;
    Number AGE;
    Number DIS;
    Number RAD;
    Number TAX;
    Number PTRATIO;
    Number B;
    Number LSTAT;
    Number MEDV;

    public Number getMEDV() {
        return MEDV;
    }

    public void setMEDV(Number MEDV) {
        this.MEDV = MEDV;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Number getCRIM() {
        return CRIM;
    }

    public void setCRIM(Number CRIM) {
        this.CRIM = CRIM;
    }

    public Number getZN() {
        return ZN;
    }

    public void setZN(Number ZN) {
        this.ZN = ZN;
    }

    public Number getINDUS() {
        return INDUS;
    }

    public void setINDUS(Number INDUS) {
        this.INDUS = INDUS;
    }

    public Number getCHAS() {
        return CHAS;
    }

    public void setCHAS(Number CHAS) {
        this.CHAS = CHAS;
    }

    public Number getNOX() {
        return NOX;
    }

    public void setNOX(Number NOX) {
        this.NOX = NOX;
    }

    public Number getRM() {
        return RM;
    }

    public void setRM(Number RM) {
        this.RM = RM;
    }

    public Number getAGE() {
        return AGE;
    }

    public void setAGE(Number AGE) {
        this.AGE = AGE;
    }

    public Number getDIS() {
        return DIS;
    }

    public void setDIS(Number DIS) {
        this.DIS = DIS;
    }

    public Number getRAD() {
        return RAD;
    }

    public void setRAD(Number RAD) {
        this.RAD = RAD;
    }

    public Number getTAX() {
        return TAX;
    }

    public void setTAX(Number TAX) {
        this.TAX = TAX;
    }

    public Number getPTRATIO() {
        return PTRATIO;
    }

    public void setPTRATIO(Number PTRATIO) {
        this.PTRATIO = PTRATIO;
    }

    public Number getB() {
        return B;
    }

    public void setB(Number b) {
        B = b;
    }

    public Number getLSTAT() {
        return LSTAT;
    }

    public void setLSTAT(Number LSTAT) {
        this.LSTAT = LSTAT;
    }


}
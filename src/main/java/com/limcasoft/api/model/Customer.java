package com.limcasoft.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "^[A-Za-zñÑáéíóúÁÉÍÓÚ ]{2,50}$", message = "Nombre no válido. Sólo debe contener letras")
    @NotEmpty(message = "El nombre es requerido")
    private String name;
    @Pattern(regexp = "^[A-Za-zñÑáéíóúÁÉÍÓÚ ]+ [A-Za-zñÑáéíóúÁÉÍÓÚ ]+$", message = "El apellido no es válido.")
    @NotEmpty(message = "Los apellidos son requeridos")
    @Column(name = "last_name")
    private String lastName;
    @Pattern(regexp = "^[\\w]+([\\.\\+\\w]+)?@([\\w-]+\\.)+[a-zzA-Z]{2,}$", message = "El correo no es válido.")
    @NotEmpty(message = "El correo es requerido")
    @Column(unique = true)
    private String email;
    @Pattern(regexp = "[0-9]+$", message = "Debe contener sólo números.")
    @NotEmpty(message = "El número es requerido")
    private String phone;
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "La dirección no es válida.")
    @NotEmpty(message = "La dirección es requerida")
    private String address;
    @Pattern(regexp = "^[a-zA-Z]{2,3}$", message = "Tipo de documento inválido.")
    @NotEmpty(message = "El tipo de documento es requerido")
    private String documentType;
    @Column(unique = true)
    @Pattern(regexp = "[0-9]+$", message = "Debe contener sólo números.")
    @NotEmpty(message = "El documento es requerido")
    private String document;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.MERGE)
    @JsonIgnore

    private List<Reservation> reservations;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", documentType=").append(documentType);
        sb.append(", document=").append(document);
        sb.append(", reservations=").append(reservations);
        sb.append('}');
        return sb.toString();
    }
    
}

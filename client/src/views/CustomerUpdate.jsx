import React, { useState, useEffect } from 'react';

export function CustomerUpdate({ cliente }) {
  const [name, setName] = useState(cliente ? cliente.name : '');
  const [lastName, setLastName] = useState(cliente ? cliente.lastName : '');
  const [email, setEmail] = useState(cliente ? cliente.email : '');
  const [phone, setPhone] = useState(cliente ? cliente.phone : '');

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const credentials = "dXNlcjpwYXNzd29yZA==";
      const headers = {
        "Authorization": `Basic ${credentials}`,
        "Content-Type": "application/json"
      };
      const response = await fetch(`http://localhost:8080/api/customers/update`, {
        method: "PUT",
        headers,
        body: JSON.stringify({ id: cliente.id, name, lastName, email, phone })
      });
      if (response.ok) {
        alert("Cliente actualizado con éxito");
      } else {
        alert("Error al actualizar el cliente");
      }
    } catch (error) {
      console.error(error);
    }
  };

  if (!cliente) {
    return <div>No se ha seleccionado un cliente</div>;
  }

  return (
    <form onSubmit={handleSubmit}>
      <label>Nombre:</label>
      <input type="text" value={name} onChange={(event) => setName(event.target.value)} />
      <br />
      <label>Apellido:</label>
      <input type="text" value={lastName} onChange={(event) => setLastName(event.target.value)} />
      <br />
      <label>Email:</label>
      <input type="email" value={email} onChange={(event) => setEmail(event.target.value)} />
      <br />
      <label>Teléfono:</label>
      <input type="text" value={phone} onChange={(event) => setPhone(event.target.value)} />
      <br />
      <button className="btn-edt" type="submit">Actualizar</button>
    </form>
  );
}
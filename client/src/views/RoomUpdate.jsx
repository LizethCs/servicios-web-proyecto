import React, { useState } from 'react';

export function RoomUpdate({ habitacion }) {
  const [number, setNumber] = useState(habitacion ? habitacion.number : '');
  const [type, setType] = useState(habitacion ? habitacion.type : '');
  const [price, setPrice] = useState(habitacion ? habitacion.price : '');

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const credentials = "dXNlcjpwYXNzd29yZA==";
      const headers = {
        "Authorization": `Basic ${credentials}`,
        "Content-Type": "application/json"
      };
      const response = await fetch(`http://localhost:8080/api/rooms/update`, {
        method: "PUT",
        headers,
        body: JSON.stringify({ id: habitacion.id, number, type, price })
      });
      if (response.ok) {
        alert("Habitación actualizada con éxito");
      } else {
        alert("Error al actualizar la habitación");
      }
    } catch (error) {
      console.error(error);
    }
  };

  if (!habitacion) {
    return <div>No se ha seleccionado una habitación</div>;
  }

  return (
    <form onSubmit={handleSubmit}>
      <label>Número:</label>
      <input type="text" value={number} onChange={(event) => setNumber(event.target.value)} />
      <br />
      <label>Tipo:</label>
      <input type="text" value={type} onChange={(event) => setType(event.target.value)} />
      <br />
      <label>Precio:</label>
      <input type="number" value={price} onChange={(event) => setPrice(event.target.value)} />
      <br />
      <button className="btn-edt" type="submit">Actualizar</button>
    </form>
  );
}
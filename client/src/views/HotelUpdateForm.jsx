import React, { useState } from 'react';

export function HotelUpdateForm({ hotel }) {
  const [name, setName] = useState(hotel ? hotel.name : '');
  const [address, setAddress] = useState(hotel ? hotel.address : '');

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const credentials = "dXNlcjpwYXNzd29yZA==";
      const headers = {
        "Authorization": `Basic ${credentials}`,
        "Content-Type": "application/json"
      };
      const response = await fetch(`http://localhost:8080/api/hotels/update`, {
        method: "PUT",
        headers,
        body: JSON.stringify({ id: hotel.id, name, address, room: [] })
      });
      if (response.ok) {
        alert("Hotel actualizado con éxito");
      } else {
        alert("Error al actualizar el hotel");
        console.log(hotel.id)
      }
    } catch (error) {
      console.error(error);
    }
  };

  if (!hotel) {
    return <div>No se ha seleccionado un hotel</div>;
  }

  return (
    <form onSubmit={handleSubmit}>
      <label>Nombre:</label>
      <input type="text" value={name} onChange={(event) => setName(event.target.value)} />
      <br />
      <label>Dirección:</label>
      <input type="text" value={address} onChange={(event) => setAddress(event.target.value)} />
      <br />
      <button type="submit">Actualizar</button>
    </form>
  );
}
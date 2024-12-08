import React, { useState} from 'react';

export function ReservationUpdate({ reserva }) {
  const [customerId, setCustomerId] = useState(reserva ? reserva.customerId : '');
  const [roomId, setRoomId] = useState(reserva ? reserva.roomId : '');
  const [startDate, setStartDate] = useState(reserva ? reserva.startDate : '');
  const [endDate, setEndDate] = useState(reserva ? reserva.endDate : '');

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const credentials = "dXNlcjpwYXNzd29yZA==";
      const headers = {
        "Authorization": `Basic ${credentials}`,
        "Content-Type": "application/json"
      };
      const response = await fetch(`http://localhost:8080/api/reservations/update`, {
        method: "PUT",
        headers,
        body: JSON.stringify({ id: reserva.id, customerId, roomId, startDate, endDate })
      });
      if (response.ok) {
        alert("Reserva actualizada con éxito");
      } else {
        alert("Error al actualizar la reserva");
      }
    } catch (error) {
      console.error(error);
    }
  };

  if (!reserva) {
    return <div>No se ha seleccionado una reserva</div>;
  }

  return (
    <form onSubmit={handleSubmit}>
      <label>ID del cliente:</label>
      <input type="text" value={customerId} onChange={(event) => setCustomerId(event.target.value)} />
      <br/>
      <label>ID de la habitación:</label>
      <input type="text" value={roomId} onChange={(event) => setRoomId(event.target.value)} />
      <br/>
      <label>Fecha de inicio:</label>
      <input type="date" value={startDate} onChange={(event) => setStartDate(event.target.value)} />
      <br/>
      <label>Fecha de fin:</label>
      <input type="date" value={endDate} onChange={(event) => setEndDate(event.target.value)} />
      <br/>
      <button className="btn-edt" type="submit">Actualizar</button>
    </form>
  );
}
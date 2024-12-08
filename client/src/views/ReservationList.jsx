import React, { useState, useEffect } from 'react';
import { ReservationUpdate } from './ReservationUpdate';
import { ReservationDelete } from './ReservationDelete';

export function ReservationList() {
  const [reservas, setReservas] = useState([]);
  const [reservaSeleccionada, setReservaSeleccionada] = useState(null);
  const credentials = "dXNlcjpwYXNzd29yZA==";

  useEffect(() => {
    const obtenerReservas = async () => {
      try {
        const headers = {
          "Authorization": `Basic ${credentials}`
        };
        const response = await fetch('http://localhost:8080/api/reservations', {headers});
        const data = await response.json();
        setReservas(data);
      } catch (error) {
        console.error(error);
      }
    };
    obtenerReservas();
  }, []);

  const handleUpdate = (reserva) => {
    setReservaSeleccionada(reserva);
  };

  return (
    <div>
      <h1>Lista de reservas</h1>
      <ul>
        {reservas.map((reserva) => (
          <li key={reserva.id}>
            <h2>ID de la reserva: {reserva.id}</h2>
            <p>ID del cliente: {reserva.customerId}</p>
            <p>ID de la habitación: {reserva.roomId}</p>
            <p>Fecha de inicio: {reserva.startDate}</p>
            <p>Fecha de fin: {reserva.endDate}</p>
            <button className="btn-edt" onClick={() => handleUpdate(reserva)}>Actualizar</button>
            <ReservationDelete reserva={reserva} />
          </li>
        ))}
      </ul>
      {reservaSeleccionada && (
        <ReservationUpdate reserva={reservaSeleccionada} />
      )}
    </div>
  );
}
import React, { useState, useEffect } from 'react';
import { RoomUpdate } from './RoomUpdate';
import { RoomDelete } from './RoomDelete';

export function RoomList() {
  const [habitaciones, setHabitaciones] = useState([]);
  const [habitacionSeleccionada, setHabitacionSeleccionada] = useState(null);
  const credentials = "dXNlcjpwYXNzd29yZA==";

  useEffect(() => {
    const obtenerHabitaciones = async () => {
      try {
        const headers = {
          "Authorization": `Basic ${credentials}`
        };
        const response = await fetch('http://localhost:8080/api/rooms', {headers});
        const data = await response.json();
        setHabitaciones(data);
      } catch (error) {
        console.error(error);
      }
    };
    obtenerHabitaciones();
  }, []);

  const handleUpdate = (habitacion) => {
    setHabitacionSeleccionada(habitacion);
  };

  return (
    <div>
      <h1>Lista de habitaciones</h1>
      <ul>
        {habitaciones.map((habitacion) => (
          <li key={habitacion.id}>
            <h2>Número: {habitacion.number}</h2>
            <p>Tipo: {habitacion.type}</p>
            <p>Precio: {habitacion.price}</p>
            <button className="btn-edt" onClick={() => handleUpdate(habitacion)}>Actualizar</button>
            <RoomDelete habitacion={habitacion} />
          </li>
        ))}
      </ul>
      {habitacionSeleccionada && (
        <RoomUpdate habitacion={habitacionSeleccionada} />
      )}
    </div>
  );
}
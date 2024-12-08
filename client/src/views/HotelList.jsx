import React, { useState, useEffect } from 'react';
import { HotelUpdateForm } from './HotelUpdateForm';
import { HotelDelete } from './HotelDelete';

export const HotelList = () => {
  const [hoteles, setHoteles] = useState([]);
  const [hotelSeleccionado, setHotelSeleccionado] = useState(null);
  const credentials = "dXNlcjpwYXNzd29yZA==";

  useEffect(() => {
    const obtenerHoteles = async () => {
      try {
        const headers = {
          "Authorization": `Basic ${credentials}`
        };
        const response = await fetch('http://localhost:8080/api/hotels', {headers});
        const data = await response.json();
        setHoteles(data);
      } catch (error) {
        console.error(error);
      }
    };
    obtenerHoteles();
  }, []);

  const handleUpdate = (hotel) => {
    setHotelSeleccionado(hotel);
  };

  return (
    <div>
      <h1>Lista de hoteles</h1>
      <ul>
        {hoteles.map((hotel) => (
          <li className="btn-htl" key={hotel.id}><br/>
            <h2>Nombre: {hotel.name}</h2><br/>
            <p>Dirección: {hotel.address}</p>
            <button className="btn-edt" onClick={() => handleUpdate(hotel)}>Actualizar</button>
            <HotelDelete hotel={hotel} />
          </li>
        ))}
      </ul>
      {hotelSeleccionado && (
        <HotelUpdateForm hotel={hotelSeleccionado} />
      )}
    </div>
  );
}
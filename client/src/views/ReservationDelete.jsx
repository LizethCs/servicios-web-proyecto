import React, { useState, useEffect } from 'react';

export function ReservationDelete({ reserva }) {
  const handleDelete = async () => {
    try {
      const credentials = "dXNlcjpwYXNzd29yZA==";
      const headers = {
        "Authorization": `Basic ${credentials}`,
      };
      const response = await fetch(`http://localhost:8080/api/reservations/${reserva.id}`, {
        method: "DELETE",
        headers,
      });
      if (response.ok) {
        alert("Reserva eliminada con éxito");
      } else {
        alert("Error al eliminar la reserva");
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <button className="btn-edt" onClick={handleDelete}>Eliminar reserva</button>
    </div>
  );
}
import React, { useState, useEffect } from 'react';
import { Navbar } from "../components/Navbar";

const ReservasCliente = () => {
  const [email, setEmail] = useState('');
  const [reservas, setReservas] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [reservaSeleccionada, setReservaSeleccionada] = useState(null);
  const [fechaInicio, setFechaInicio] = useState('');
  const [fechaFin, setFechaFin] = useState('');

  useEffect(() => {
    const obtenerReservas = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/reservations', {
          method: 'GET',
          headers: {
            'Authorization': 'Basic dXNlcjpwYXNzd29yZA=='
          }
        });
        const data = await response.json();
        setReservas(data);
      } catch (error) {
        setError(error.message);
      }
    };
    obtenerReservas();
  }, []);

  const handleSubmit = async (event) => {
    event.preventDefault();
    const reservasCliente = reservas.filter((reserva) => reserva.customer && reserva.customer.email === email);
    if (reservasCliente.length > 0) {
      setReservas(reservasCliente);
    } else {
      setError('No se encontraron reservas para el email proporcionado');
    }
  };

  const handleEditarReserva = async (reservaId) => {
    setReservaSeleccionada(reservaId);
    const reserva = reservas.find((r) => r.id === reservaId);
    setFechaInicio(reserva.checkInDate);
    setFechaFin(reserva.checkOutDate);
  };

  const handleGuardarCambios = async () => {
    const reserva = reservas.find((r) => r.id === reservaSeleccionada);
    const response = await fetch(`http://localhost:8080/api/reservations/update`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Basic dXNlcjpwYXNzd29yZA=='
      },
      body: JSON.stringify({
        id: reserva.id,
        customer: { id: reserva.customer.id },
        room: { id: reserva.room.id },
        checkInDate: fechaInicio,
        checkOutDate: fechaFin
      })
    });
    const data = await response.json();
    setReservas(reservas.map((r) => r.id === reservaSeleccionada ? data : r));
    setReservaSeleccionada(null);
  };

  const handleEliminarReserva = async (reservaId) => {
    const response = await fetch(`http://localhost:8080/api/reservations/${reservaId}`, {
      method: 'DELETE',
      headers: {
        'Authorization': 'Basic dXNlcjpwYXNzd29yZA=='
      }
    });
    setReservas(reservas.filter((r) => r.id !== reservaId));
  };

  const handleCancelarEdicion = () => {
    setReservaSeleccionada(null);
  };

  return (
    <>
    <Navbar/>
    <div>
      <h1>Verificar y gestionar reservas</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Email:
          <input type="email" value={email} onChange={(event) => setEmail(event.target.value)} />
        </label>
        <button className="btn-edt" type="submit">Buscar reservas</button>
      </form>
      {loading ? (
        <p>Cargando...</p>
      ) : (
        <div>
          {reservas.length > 0 ? (
            <ul>
              {reservas.map((reserva) => (
                <li key={reserva.id}>
                  <p>Reserva {reserva.id}</p>
                  <p>Fecha de inicio: {reserva.checkInDate}</p>
                  <p>Fecha de fin: {reserva.checkOutDate}</p>
                  {reservaSeleccionada === reserva.id ? (
                    <div>
                      <label>
                        Fecha de inicio:
                        <input type="text" value={fechaInicio} onChange={(event) => setFechaInicio(event.target.value)} />
                      </label>
                      <label>
                        Fecha de fin:
                        <input type="text" value={fechaFin} onChange={(event) => setFechaFin(event.target.value)} />
                      </label>
                      <button className="btn-edt" onClick={() => handleGuardarCambios()}>Guardar cambios</button>
                      <button className="btn-edt" onClick={() => handleCancelarEdicion()}>Cancelar edición</button>
                    </div>
                  ) : (
                    <div>
                      <button className="btn-edt" onClick={() => handleEditarReserva(reserva.id)}>Editar</button>
                      <button className="btn-edt" onClick={() => handleEliminarReserva(reserva.id)}>Eliminar</button>
                                        </div>
                  )}
                </li>
              ))}
            </ul>
          ) : (
            <p>No se encontraron reservas para el email proporcionado</p>
          )}
        </div>
      )}
      {error ? (
        <p>Error: {error}</p>
      ) : null}
    </div>
    </>
  );
};

export default ReservasCliente;
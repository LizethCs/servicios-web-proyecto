import { useState, useEffect } from 'react';
import "../styles/reservar.css"
import { Navbar } from "../components/Navbar";

export const Reservar = () => {
  const [reservedRooms, setReservedRooms] = useState([]);
  const [allRooms, setAllRooms] = useState([]);
  const [nombre, setNombre] = useState('');
  const [apellidos, setApellidos] = useState('');
  const [email, setEmail] = useState('');
  const [direccion, setDireccion] = useState('');
  const [numero, setNumero] = useState('');
  const [tipoIdentificacion, setTipoIdentificacion] = useState('');
  const [documento, setDocumento] = useState('');
  const [fechaInicio, setFechaInicio] = useState('');
  const [fechaFin, setFechaFin] = useState('');
  const [habitaciones, setHabitaciones] = useState([]);
  const [clienteId, setClienteId] = useState(null);

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/api/customers', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Basic dXNlcjpwYXNzd29yZA=='
        },
        body: JSON.stringify({
          name: nombre,
          lastName: apellidos,
          email: email,
          address: direccion,
          phone: numero,
          documentType: tipoIdentificacion,
          document: documento
        })
      });
      const data = await response.json();
      setClienteId(data.id);
      console.log(data);
      alert('Cliente registrado con éxito');
      obtenerHabitaciones();
    } catch (error) {
      console.error(error);
      alert('Error al registrar cliente');
    }
  };

  const obtenerReservaciones = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/reservations', {
        method: 'GET',
        headers: {
          'Authorization': 'Basic dXNlcjpwYXNzd29yZA=='
        }
      });
      const data = await response.json();
      const reservedRoomsArray = data.map(reservation => reservation.room);
      setReservedRooms(reservedRoomsArray);
    } catch (error) {
      console.error(error);
      alert('Error al obtener reservaciones');
    }
  };

  const obtenerHabitaciones = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/rooms', {
        method: 'GET',
        headers: {
          'Authorization': 'Basic dXNlcjpwYXNzd29yZA=='
        }
      });
      const data = await response.json();
      setAllRooms(data);
    } catch (error) {
      console.error(error);
      alert('Error al obtener habitaciones');
    }
  };

  const reservarHabitacion = async (habitacionId) => {
    try {
      const habitacion = habitaciones.find(h => h.id === habitacionId);
      const customer = {
        id: clienteId,
        name: nombre,
        lastName: apellidos,
        email: email,
        address: direccion,
        phone: numero,
        documentType: tipoIdentificacion,
        document: documento
      };
      const response = await fetch(`http://localhost:8080/api/reservations`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Basic dXNlcjpwYXNzd29yZA=='
        },
        body: JSON.stringify({
          room: habitacion,
          customer: customer,
          checkInDate: fechaInicio,
          checkOutDate: fechaFin
        })
      });
      const data = await response.json();
      console.log(data);
      alert('Habitación reservada con éxito');
    } catch (error) {
      console.error(error);
      alert('Error al reservar habitación');
    }
  };
  useEffect(() => {
    obtenerReservaciones();
    obtenerHabitaciones();
  }, []);
  
  useEffect(() => {
    const availableRooms = allRooms.filter(room => !reservedRooms.find(reservedRoom => reservedRoom !== null && reservedRoom.id === room.id));
    setHabitaciones(availableRooms);
  }, [allRooms, reservedRooms]);

  return (
    <>
    <Navbar/>
      <h1 className="title">Haz tu reserva</h1>
      <form onSubmit={handleSubmit} id="form">
        <fieldset>
          <label htmlFor="name" id="name-label"
            >Nombre
            <input
              type="text"
              id="name"
              required
              placeholder="Ingrese su nombre(s)"
              className="input-height input"
              value={nombre}
              onChange={(event) =>
                setNombre(event.target.value)}
            />
          </label>
          <label htmlFor="last-name" id="last-name-label"
                >Apellidos
                <input
                  type="text"
                  id="last-name"
                  required
                  placeholder="Ingrese sus apellidos"
                  className="input-height input"
                  value={apellidos}
                  onChange={(event) => setApellidos(event.target.value)}
                />
              </label>
              <label htmlFor="email" id="email-label"
            >Email
            <input
              type="email"
              id="email"
              required
              placeholder="Ingrese su email"
              className="input-height input"
              value={email}
              onChange={(event) => setEmail(event.target.value)}
            />
          </label>
          <label htmlFor="address" id="address-label"
            >Dirección
            <input
              type="text"
              id="address"
              placeholder="Dirección"
              className="input-height input"
              value={direccion}
              onChange={(event) => setDireccion(event.target.value)}
            />
          </label>
          <label htmlFor="number" id="number-label"
            >Télefono
            <input
              type="number"
              id="number"
              required
              placeholder="Número de contacto"
              className="input-height input"
              value={numero}
                onChange={(event) => setNumero(event.target.value)}
              />
            </label>
            <label htmlFor="dropdown" id=""
              >Tipo de identificación
              <select name="dropdown" id="dropdown" value={tipoIdentificacion} onChange={(event) => setTipoIdentificacion(event.target.value)}>
                <option value="" className="input">Seleccione el documento</option>
                <option value="CC" className="input">CC</option>
                <option value="CE" className="input">CE</option>
                <option value="PEP" className="input">PEP</option>
                <option value="PPT" className="input">PPT</option>
              </select>
            </label>
            <label htmlFor="documento" id="documento-label"
              >Documento
              <input
                type="text"
                id="documento"
                required
                placeholder="Número de documento"
                className="input-height input"
                value={documento}
                onChange={(event) => setDocumento(event.target.value)}
              />
            </label>
            <label htmlFor="init-date" id="init-date-label"
              >Fecha Inicio
              <input
                type="text"
                id="init-date"
                required
                placeholder="Fecha inicio de reserva"
                className="input-height input"
                value={fechaInicio}
                onChange={(event) => setFechaInicio(event.target.value)}
              />
            </label>
            <label htmlFor="end-date" id="end-date-label"
              >Fecha Fin
              <input
                type="text"
                id="end-date"
                required
                placeholder="Fecha fin de reserva"
                className="input-height input"
                value={fechaFin}
                onChange={(event) => setFechaFin(event.target.value)}
              />
            </label>
            <button type="submit" id="reservar" className="rsrv-button round">
              Registrar información
            </button>
          </fieldset>
        </form>
        {habitaciones.length > 0 ? (
  <div className="hab-cont">
    <br/><br/>
    <h2>Habitaciones disponibles</h2><br/>
    <ul>
      {habitaciones.map((habitacion) => (
        <li className="habitacion" key={habitacion.id}>
          <button className="habitacion" onClick={() => reservarHabitacion(habitacion.id)}>
           <strong>Reservar habitación -</strong> <br/>
            Número: {habitacion.number}<br/>
            Tipo: {habitacion.type}<br/>
            Precio: {habitacion.price} 

          </button>
        </li>
      ))}
    </ul>
  </div>
) : (
  <p>No hay habitaciones disponibles</p>
)}
      </>
    )
  }
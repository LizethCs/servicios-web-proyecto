export function HotelDelete({ hotel }) {
  const handleDelete = async () => {
    try {
      const credentials = "dXNlcjpwYXNzd29yZA==";
      const headers = {
        "Authorization": `Basic ${credentials}`,
      };
      const response = await fetch(`http://localhost:8080/api/hotels/${hotel.id}`, {
        method: "DELETE",
        headers,
      });
      if (response.ok) {
        alert("Hotel eliminado con éxito");
      } else {
        alert("Error al eliminar el hotel");
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <button className="btn-edt" onClick={handleDelete}>Eliminar hotel</button>
    </div>
  );
}
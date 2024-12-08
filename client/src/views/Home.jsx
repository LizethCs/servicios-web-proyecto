import "../styles/styles.css"
import { Navbar } from "../components/Navbar";
import { Footer } from "../components/Footer";
import { Card } from "../components/Card";

export const Home = () => {
    return(
        <>
            <Navbar />
            <main>
                <section className="img-container flex">
                    <h1 className="h-1">Bienvenidos a nuestro hotel</h1>
                </section>
                <section>
                    <h2 className="title" id="servicios">Servicios</h2>
                    <div className="item flex">
                        <Card>
                            En nuestro hotel, nos esforzamos por brindarle una experiencia inolvidable. Nuestros servicios incluyen habitaciones cómodas y bien equipadas, un desayuno buffet completo, acceso a nuestro gimnasio y spa, y un servicio de conserjería disponible las 24 horas del día.
                        </Card>
                        <Card>
                            Nuestro hotel ofrece una variedad de servicios para hacer que su estancia sea lo más cómoda posible. Nuestros servicios incluyen:<br/>
                            Un servicio de lavandería y planchado.<br/>
                            Un servicio de transporte al aeropuerto.
                        </Card>
                        <Card>
                        En nuestro hotel, nos comprometemos a brindarle una experiencia de lujo y comodidad. Nuestros servicios incluyen:<br/>
Habitaciones de lujo con vistas impresionantes de la ciudad.<br/>
Un spa y centro de bienestar con tratamientos de masaje y terapias.<br/>
Un gimnasio completamente equipado.<br/>
Un servicio de conserjería personalizado.
                        </Card>
                    </div>
                </section>
                <section className="item flex">
                    <h2 className="title" id="habitaciones">Habitaciones</h2>
                    <div className="item flex">
                        <figure>
                            <img
                                className="room round"
                                src="https://res.cloudinary.com/dx9mnazdx/image/upload/v1733185345/indivual_ijjfxm.jpg"
                                alt="habitación individual"
                            />
                            <figcaption className="text">
                                Habitación individual
                            </figcaption>
                        </figure>
                    </div>
                </section>
                <section className="item flex">
                    <h2 className="title" id="precios">Precios</h2>
                    <Card>
                        <strong>Habitación individual</strong><br/><br/>
                        Una habitación individual tiene el costo de<br/><br/>
                        <em>$50.000</em>
                    </Card>
                    <Card>
                        <strong>Habitación doble</strong><br/><br/>
                        Una habitación doble tiene el costo de<br/><br/>
                        <em>$100.000</em>
                    </Card>
                    <Card>
                        <strong>Habitación familiar</strong><br/><br/>
                        Una habitación familiar tiene el costo de<br/><br/>
                        <em>$300.000</em>
                    </Card>
                </section>
            </main>
            <Footer />
        </>
    )
}

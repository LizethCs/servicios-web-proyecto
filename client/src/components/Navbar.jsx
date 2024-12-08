import "../styles/styles.css"


import navlinks from "../utils/navlinks.json"
import { useState, useEffect, useRef } from "react"
import { useMediaQuery } from "react-responsive"
const setLinks = ({ href, text }) => (
  <li className="nav-item" key={href}>
    <a className="nav-link medium" href={href}>
      {text}
    </a>
  </li>
)

export const Navbar = () => {
  const isMaxWidth = useMediaQuery({ query: "(max-width: 721px)" })
  const elementRef = useRef(null)
  const [isVisible, setIsVisible] = useState(false)

  useEffect(() => {
    if (elementRef.current) {
      elementRef.current.style.display = isMaxWidth ? "block" : "flex"
    }
  }, [isMaxWidth])

  const handleClick = () => setIsVisible(!isVisible)
  
  return (
    <>
      <header>
        <nav>
          <a id="home" href="#">
            <img
              src="https://res.cloudinary.com/dx9mnazdx/image/upload/v1721400503/image-010_lhu14t-removebg-preview_kt7e2c.png"
              alt="logo del hotel"
              id="logo"
              className="nav-link"
            />
          </a>
          <div
            ref={elementRef}
            id="links"
            style={{ display: isMaxWidth && isVisible ? "none" : "block" }}
        
          >
            {navlinks.map(setLinks)}
          </div>
          <button className="menu-btn" type="button" onClick={handleClick}>
            <img
              src="https://res.cloudinary.com/dx9mnazdx/image/upload/v1721404811/hamburger_c3mvp3.png"
              alt="toggle-navbar-button"
            />
          </button>
        </nav>
      </header>
    </>
  )
}
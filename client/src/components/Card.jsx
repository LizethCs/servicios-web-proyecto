import "../styles/styles.css"

export const Card = ({children}) => {
    return(
        <div className="round card">
            <p className="text">
                {children}
            </p>
        </div>
    )
}
import "./Card.css"

interface CardProps{
    price: number,
    title: string,
    description: string,
    image: string
}

export function Card({image, title, description, price}: CardProps){
    return(
        <div className="card">
            <img src={image} alt={title} />
            <h2>{title}</h2>
            <p>{description}</p>
            <small>Valor: {price}</small>
        </div>
    )
}
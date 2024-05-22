import { useState } from "react"
import { Card } from "./components/Card/Card"
import { useFoodData } from "./hooks/useFoodData"
import { FoodFormModal } from "./components/FoodFormModal/FoodFormModal"

function App() {

  const { data } = useFoodData()
  const [isModalOpen, setIsModalOpen] = useState(false)

  const handleModalOpen = () =>{
    setIsModalOpen(!isModalOpen)
  }

  return (
    <main>
      <div>
        <h1>Cardápio</h1>
        <div>
          {data?.map(
            foodData=>
              <Card
                title={foodData.title}
                description={foodData.description} 
                image={foodData.image}
                price={foodData.price}
                key={foodData.id}
              />
           )}
        </div>
      </div>
      {isModalOpen && <FoodFormModal callback={handleModalOpen}/>}
      <button onClick={handleModalOpen}>Novo</button>
    </main>
  )
}

export default App

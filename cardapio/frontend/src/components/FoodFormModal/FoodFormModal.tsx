import { useEffect, useState } from "react";
import { useFoodDataCreate } from "../../hooks/useFoodDataCreate";
import { TextInput } from "../TextInput/TextInput";
import { FoodData } from "../../interface/FoodData";

interface FoodFormModalProps{
    callback: ()=> void
}

export function FoodFormModal({callback}: FoodFormModalProps){

    const [title, setTitle] = useState('')
    const [description, setDescription] = useState('')
    const [image, setImage] = useState('')
    const [price, setPrice]= useState(0)
    
    const {mutate, isSuccess} = useFoodDataCreate()

    useEffect(()=>{
        if(isSuccess){
            callback()
        }
    },[isSuccess])

    const submit = ()=>{
        const foodData: FoodData = {
            title,
            description,
            price,
            image
        }
        mutate(foodData)
    }
    

    return(
        <div>
            <div>
                <h2>Cadastrar novo item</h2>
                <form>
                    <TextInput label="title" value={title} updateValue={setTitle}/>
                    <TextInput label="description" value={description} updateValue={setDescription}/>
                    <TextInput label="image" value={image} updateValue={setImage}/>
                    <TextInput label="price" value={price} updateValue={setPrice}/>
                </form>
                <button onClick={submit}>Enviar</button>
            </div>
        </div>
    )

}
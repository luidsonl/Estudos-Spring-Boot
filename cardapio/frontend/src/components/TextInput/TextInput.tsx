interface TextInputProps{
    label: string,
    value: string | number,
    updateValue:(value: any)=> void
}

export function TextInput({label,value, updateValue}: TextInputProps){
    return(
        <>
            <label>{label}</label>
            <input type="text" value={value} onChange={e=>updateValue(e.target.value)}/>
        </>
    )
}
import React, {useState} from 'react';
import logo from './logo.svg';
import './App.css';


// type TitleProps = {
//   name:string
// }

interface TitleProps{
  name:string
  desc?:string
}

const Title:React.FC<TitleProps>=({name})=>{
  return <p>{name}</p>
}

const App:React.FunctionComponent=()=>{
  const [title, setTitle] = useState<number | string>('str')
  return (
    <div>
      <Title name="Burce" desc="..."/>



    </div>
  );
}

export default App;

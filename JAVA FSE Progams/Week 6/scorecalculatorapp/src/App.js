import './App.css';
import { CalculateScore } from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore Name="Pravallika" School="ABC High School" total={480} goal={500} />
    </div>
  );
}

export default App;

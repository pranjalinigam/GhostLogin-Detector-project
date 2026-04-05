import React from 'react'

export default function RiskChart(){
  const data = [
    {label:'Low', value:65, color:'bg-green-400'},
    {label:'Medium', value:20, color:'bg-yellow-400'},
    {label:'High', value:15, color:'bg-red-400'}
  ]
  const max = Math.max(...data.map(d => d.value))

  return (
    <div className="w-full flex items-end gap-6 h-48">
      {data.map((d) => (
        <div key={d.label} className="flex flex-col items-center">
          <div className={`w-12 ${d.color} rounded-t-xl transition-all`} style={{height: `${(d.value/max)*100}%`}}></div>
          <div className="mt-3 text-sm font-semibold">{d.value}%</div>
          <div className="text-xs text-gray-600 mt-1">{d.label}</div>
        </div>
      ))}
    </div>
  )
}

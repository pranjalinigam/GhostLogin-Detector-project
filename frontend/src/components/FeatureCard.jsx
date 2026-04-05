import React from 'react'

export default function FeatureCard({icon, title, text}){
  return (
    <div className="p-6 bg-white rounded-xl shadow hover:shadow-lg transition transform hover:-translate-y-1">
      <div className="text-3xl w-12 h-12 bg-gray-100 rounded-full flex items-center justify-center">{icon}</div>
      <h4 className="mt-4 font-semibold text-lg">{title}</h4>
      <p className="mt-2 text-sm text-gray-600">{text}</p>
    </div>
  )
}

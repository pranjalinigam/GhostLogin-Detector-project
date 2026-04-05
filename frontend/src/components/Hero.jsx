import React from 'react'
import { useNavigate } from 'react-router-dom'
import heroImg from '../assets/hero.jpg'

export default function Hero() {
  const navigate = useNavigate()

  const handleTryDemo = () => {
    navigate('/features') // or wherever demo is
  }

  const handleLearnMore = () => {
    navigate('/about')
  }

  return (
    <section className="py-20 bg-gradient-to-r from-purple-600 to-teal-400">
      <div className="px-6 flex flex-col md:flex-row items-center">
        <div className="md:w-1/2 text-center md:text-left">
          <h1 className="text-4xl md:text-5xl font-bold text-white leading-tight">
            Secure Your Accounts with <span className="bg-gradient-to-r from-yellow-400 to-orange-500 bg-clip-text text-transparent">GhostLogin Detector</span>
          </h1>
          <p className="mt-4 text-white text-lg max-w-md">
            Advanced AI-powered security to detect and prevent unauthorized access attempts in real-time.
          </p>
          <div className="mt-8 flex flex-col sm:flex-row gap-4 justify-center md:justify-start">
            <button
              onClick={handleTryDemo}
              className="px-6 py-3 bg-white text-purple-600 rounded-xl shadow-lg hover:shadow-xl transition font-semibold"
              aria-label="Try Live Demo"
            >
              Try Live Demo
            </button>
            <button
              onClick={handleLearnMore}
              className="px-6 py-3 bg-transparent border-2 border-white text-white rounded-xl hover:bg-white hover:text-purple-600 transition font-semibold"
              aria-label="Learn More"
            >
              Learn More
            </button>
          </div>
        </div>
        <div className="md:w-1/2 mt-10 md:mt-0">
          <img src={heroImg} alt="Hero illustration" className="w-full max-w-md mx-auto rounded-xl shadow-lg" />
        </div>
      </div>
    </section>
  )
}

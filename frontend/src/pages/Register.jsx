import React from 'react'
import { useNavigate } from 'react-router-dom'
import bg from '../assets/hero.jpg' // confirm filename

export default function Register() {
  const navigate = useNavigate()

  const handleSubmit = (e) => {
    e.preventDefault()
    navigate('/dashboard')
  }

  return (
    <div className="min-h-screen bg-gradient-to-r from-purple-600 to-teal-400 flex items-center justify-center py-12 px-6">
      <div className="w-full max-w-md">
        <div className="bg-white rounded-xl shadow-lg p-8">
          <h1 className="text-2xl sm:text-3xl font-extrabold text-gray-900 text-center">Register to Continue</h1>
          <p className="mt-2 text-sm text-gray-600 text-center">Create your account to access GhostLogin Detector</p>

          <form className="mt-6 space-y-4" onSubmit={handleSubmit}>
            <div>
              <label htmlFor="email" className="block text-sm font-medium text-gray-700">Email</label>
              <input
                type="email"
                id="email"
                name="email"
                required
                className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-purple-500 focus:border-purple-500"
                placeholder="Enter your email"
              />
            </div>
            <div>
              <label htmlFor="password" className="block text-sm font-medium text-gray-700">Password</label>
              <input
                type="password"
                id="password"
                name="password"
                required
                className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-purple-500 focus:border-purple-500"
                placeholder="Enter your password"
              />
            </div>
            <button
              type="submit"
              className="w-full py-2 px-4 bg-gradient-to-r from-purple-600 to-teal-400 text-white rounded-md hover:from-purple-700 hover:to-teal-500 transition font-semibold"
            >
              Register
            </button>
          </form>

          <p className="mt-4 text-xs text-gray-500 text-center">By registering you agree to our Terms of Service and Privacy Policy.</p>
        </div>
      </div>
    </div>
  )
}

// src/context/AuthContext.jsx
import React, { createContext, useState, useEffect } from 'react'

export const AuthContext = createContext()

export function AuthProvider({ children }) {
  const [user, setUser] = useState(null)      // store user profile info
  const [token, setToken] = useState(null)    // store JWT access token
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    // Try to load token and user from localStorage on mount
    const savedToken = localStorage.getItem('token')
    const savedUser = localStorage.getItem('user')
    if (savedToken && savedUser) {
      setToken(savedToken)
      setUser(JSON.parse(savedUser))
    }
    setLoading(false)
  }, [])

  const login = (jwtToken, userProfile) => {
    setToken(jwtToken)
    setUser(userProfile)
    localStorage.setItem('token', jwtToken)
    localStorage.setItem('user', JSON.stringify(userProfile))
  }

  const logout = () => {
    setToken(null)
    setUser(null)
    localStorage.removeItem('token')
    localStorage.removeItem('user')
  }

  return (
    <AuthContext.Provider value={{ user, token, login, logout, loading }}>
      {children}
    </AuthContext.Provider>
  )
}

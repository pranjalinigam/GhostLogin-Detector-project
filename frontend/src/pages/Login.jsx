// src/pages/Login.jsx
import React, { useContext, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { AuthContext } from '../context/AuthContext'

export default function Login() {
  const { login } = useContext(AuthContext)
  const navigate = useNavigate()
  const [error, setError] = useState(null)

  async function handleOAuthLogin() {
    try {
      // TODO: Replace with actual OAuth login flow (e.g. Auth0 SDK)
      // Example: get access token from OAuth provider:
      const jwtToken = await fakeOAuthLogin()

      // Fetch user profile from backend /auth/me
      const res = await fetch('/auth/me', {
        headers: {
          Authorization: `Bearer ${jwtToken}`,
        },
      })

      if (!res.ok) throw new Error('Failed to fetch user profile')

      const userProfile = await res.json()

      // Save user profile and token in context
      login(jwtToken, userProfile)

      // Navigate to register if new user (handle your own logic),
      // otherwise to dashboard
      if (isNewUser(userProfile)) {
        navigate('/register')
      } else {
        navigate('/dashboard')
      }
    } catch (e) {
      setError(e.message)
    }
  }

  return (
    <div>
      <button onClick={handleOAuthLogin}>Login with OAuth Provider</button>
      {error && <p className="error">{error}</p>}
    </div>
  )
}

// Dummy functions for example:
async function fakeOAuthLogin() {
  // Simulate login and return a JWT token string
  return 'fake.jwt.token'
}

function isNewUser(userProfile) {
  // Your logic to check if user profile needs registration
  return !userProfile.registered // example
}

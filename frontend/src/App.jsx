import React from 'react'
import { BrowserRouter, Routes, Route, useLocation } from 'react-router-dom'
import Header from './components/Header'
import Footer from './components/Footer'
import Sidebar from './components/Sidebar'
import Register from './pages/Register'
import Home from './pages/Home'
import Features from './pages/Features'
import About from './pages/About'
import Dashboard from './pages/Dashboard'

function LayoutSimple({ children }) {
  return (
    <>
      <Header />
      <main className="min-h-screen">{children}</main>
      <Footer />
    </>
  )
}

function LayoutWithSidebar({ children }) {
  return (
    <div className="h-screen flex flex-col bg-gradient-to-r from-slate-900 to-slate-800 text-white">
      <Header />
      <div className="flex flex-1">
        <aside className="w-64">
          <Sidebar />
        </aside>
        <main className="flex-1 overflow-auto">{children}</main>
      </div>
      <Footer />
    </div>
  )
}

function AppContent() {
  const location = useLocation()

  const simpleRoutes = ['/', '/home', '/features', '/about', '/register']
  const isSimple = simpleRoutes.includes(location.pathname)

  return isSimple ? (
    <LayoutSimple>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/features" element={<Features />} />
        <Route path="/about" element={<About />} />
        <Route path="/register" element={<Register />} />
      </Routes>
    </LayoutSimple>
  ) : (
    <LayoutWithSidebar>
      <Routes>
        <Route path="/dashboard" element={<Dashboard />} />
      </Routes>
    </LayoutWithSidebar>
  )
}

export default function App() {
  return (
    <BrowserRouter>
      <AppContent />
    </BrowserRouter>
  )
}

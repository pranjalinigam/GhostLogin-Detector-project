import React from 'react'
import { Link } from 'react-router-dom'

export default function Header() {
  const [open, setOpen] = React.useState(false)

  const nav = [
    { name: 'Home', to: '/' },
    { name: 'Features', to: '/features' },
    { name: 'About', to: '/about' },
    { name: 'Dashboard', to: '/dashboard' }
  ]

  return (
    <header className="relative z-30 px-6">
      <div className="max-w-7xl mx-auto glass shadow-lg backdrop-blur-md rounded-2xl py-4 px-6 flex items-center justify-between">
        <div className="flex items-center gap-4">
          <img src="/src/assets/logo.svg" alt="logo" className="w-11 h-11" />
          <div>
            <div className="text-lg font-extrabold text-gray-900">GhostLogin</div>
            <div className="text-xs text-gray-500">Detector</div>
          </div>
        </div>
        <nav className="hidden md:flex items-center gap-8">
          {nav.map((n) => (
            <Link
              key={n.to}
              to={n.to}
              className="text-sm text-gray-700 hover:text-brand-600"
              onClick={() => setOpen(false)}
            >
              {n.name}
            </Link>
          ))}
        </nav>
        <div className="md:hidden">
          <button onClick={() => setOpen(!open)} className="p-2">
            {/* svg icon */}
          </button>
        </div>
      </div>

      {open && (
        <div className="mt-2 bg-white rounded-xl shadow p-4 max-w-3xl mx-auto md:hidden">
          {nav.map((n) => (
            <div key={n.to} className="py-2 border-b last:border-b-0">
              <Link
                to={n.to}
                className="w-full text-left"
                onClick={() => setOpen(false)}
              >
                {n.name}
              </Link>
            </div>
          ))}
        </div>
      )}
    </header>
  )
}

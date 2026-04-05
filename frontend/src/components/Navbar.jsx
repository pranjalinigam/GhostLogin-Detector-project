import React from 'react'

export default function Navbar() {
  return (
    <header className="w-full bg-white/5 backdrop-blur-sm border-b border-white/10">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex items-center justify-between h-16">
          <div className="flex items-center">
            <div className="text-white font-bold text-lg">GhostLogin</div>
          </div>

          <div className="hidden md:flex items-center space-x-4">
            <nav className="text-sm text-white/80">
              <a className="px-3 py-2 rounded-md hover:bg-white/5" href="#">Overview</a>
              <a className="px-3 py-2 rounded-md hover:bg-white/5" href="#">Analytics</a>
              <a className="px-3 py-2 rounded-md hover:bg-white/5" href="#">Settings</a>
            </nav>

            <div>
              <button className="px-3 py-1 bg-blue-600 text-white rounded-md text-sm">Account</button>
            </div>
          </div>
        </div>
      </div>
    </header>
  )
}

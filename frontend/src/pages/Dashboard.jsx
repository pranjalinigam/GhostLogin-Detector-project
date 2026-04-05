import React from 'react'
import Navbar from '../components/Navbar'
import Sidebar from '../components/Sidebar'

export default function Dashboard() {
  return (
    <div className="min-h-screen bg-gradient-to-b from-slate-900 to-slate-800 text-white">
      <Navbar />

      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 flex">
        {/* Sidebar (left) */}
        <div className="hidden md:block">
          <Sidebar />
        </div>

        {/* Main content area */}
        <main className="flex-1 py-10 px-4 sm:px-6 lg:px-8">
          <div className="max-w-4xl">
            <h1 className="text-3xl md:text-4xl font-extrabold">Dashboard</h1>
            <p className="mt-2 text-white/80">Welcome to GhostLogin Detector</p>

            {/* Placeholder content box */}
            <div className="mt-6 grid grid-cols-1 gap-6">
              <section className="p-6 bg-white/5 rounded-lg border border-white/6">
                <h2 className="text-lg font-semibold">Quick Overview</h2>
                <p className="mt-2 text-white/80">Recent login events, risk scores, and alerts appear here.</p>
              </section>
            </div>
          </div>
        </main>
      </div>
    </div>
  )
}

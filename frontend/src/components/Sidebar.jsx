import React from 'react'

export default function Sidebar() {
  return (
    <aside className="w-64 bg-white/3 hidden md:block border-r border-white/5">
      <div className="h-full px-4 py-6">
        <div className="text-sm text-white/80 font-medium mb-4">Navigation</div>
        <ul className="space-y-2">
          <li>
            <a className="block px-3 py-2 rounded-md hover:bg-white/5 text-white/90" href="#">Dashboard</a>
          </li>
          <li>
            <a className="block px-3 py-2 rounded-md hover:bg-white/5 text-white/90" href="#">Login Events</a>
          </li>
          <li>
            <a className="block px-3 py-2 rounded-md hover:bg-white/5 text-white/90" href="#">Trusted Devices</a>
          </li>
          <li>
            <a className="block px-3 py-2 rounded-md hover:bg-white/5 text-white/90" href="#">Risk Analytics</a>
          </li>
        </ul>
      </div>
    </aside>
  )
}

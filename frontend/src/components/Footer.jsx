import React from 'react'

export default function Footer(){
  return (
    <footer className="bg-white mt-12 border-t py-6">
      <div className="container mx-auto px-6 text-center text-sm text-gray-600 flex items-center justify-between">
        <div>© {new Date().getFullYear()} GhostLogin Detector</div>
        <div className="text-xs text-gray-400">Built with care • <a className="text-brand-500" href="#">Privacy</a></div>
      </div>
    </footer>
  )
}

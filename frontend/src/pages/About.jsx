import React from 'react'

export default function About(){
  return (
    <div className="container mx-auto px-6 py-20">
      <h1 className="text-3xl font-bold">About GhostLogin Detector</h1>
      <p className="mt-4 text-gray-600 max-w-3xl">GhostLogin Detector is a lightweight, privacy-first system that helps teams detect and respond to unauthorized access attempts. Built for speed and clarity, it blends heuristics with risk-level visualization for simple operational decisions.</p>

      <section className="mt-12">
        <h2 className="text-2xl font-semibold">Why this system is different</h2>
        <ul className="mt-4 space-y-4">
          <li className="bg-white p-4 rounded-xl shadow">Fast, sign-posted alerts so you can act quickly.</li>
          <li className="bg-white p-4 rounded-xl shadow">Actionable risk labels combined with session controls.</li>
          <li className="bg-white p-4 rounded-xl shadow">Privacy friendly: minimal data retained by default.</li>
        </ul>
      </section>

      <section className="mt-12">
        <h2 className="text-2xl font-semibold">Roadmap</h2>
        <div className="mt-6 space-y-6">
          <div className="flex items-start gap-4">
            <div className="w-10 h-10 rounded-full bg-purple-600 text-white flex items-center justify-center">1</div>
            <div>
              <div className="font-semibold">MVP Launch</div>
              <div className="text-sm text-gray-600">Core detection, demo panel, basic analytics.</div>
            </div>
          </div>
          <div className="flex items-start gap-4">
            <div className="w-10 h-10 rounded-full bg-teal-500 text-white flex items-center justify-center">2</div>
            <div>
              <div className="font-semibold">Automation & rules</div>
              <div className="text-sm text-gray-600">Actionable rules and auto-remediation pipelines.</div>
            </div>
          </div>
          <div className="flex items-start gap-4">
            <div className="w-10 h-10 rounded-full bg-gray-400 text-white flex items-center justify-center">3</div>
            <div>
              <div className="font-semibold">Enterprise features</div>
              <div className="text-sm text-gray-600">SAML, Audit logs, and SOC integrations.</div>
            </div>
          </div>
        </div>
      </section>

      <section className="mt-12">
        <div className="bg-gradient-to-r from-purple-600 to-teal-400 p-8 rounded-xl text-white">
          <h3 className="text-xl font-bold">Get started with GhostLogin</h3>
          <p className="mt-2">Sign up for the demo and evaluate risk detection on your tenant.</p>
          <div className="mt-4">
            <button className="px-4 py-2 bg-white text-purple-700 rounded">Request Demo</button>
          </div>
        </div>
      </section>
    </div>
  )
}

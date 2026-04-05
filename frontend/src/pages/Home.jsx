import React from 'react'
import FeatureCard from '../components/FeatureCard'
import DemoPanel from '../components/DemoPanel'
import Hero from '../components/Hero'

export default function Home(){
  const features = [
    {icon: '🔒', title: 'Real-time detection', text: 'Spot suspicious logins instantly.'},
    {icon: '📊', title: 'Risk analytics', text: 'Understand risk distribution over time.'},
    {icon: '⚡', title: 'Fast response', text: 'Automated rules and alerts.'}
  ]

  return (
    <>
      {/* Hero */}
      <Hero />

      <div className="px-6 py-24">
        {/* Why section */}
        <section className="mt-16">
          <h2 className="text-2xl font-bold">Why GhostLogin Detector?</h2>
          <div className="mt-6 grid grid-cols-1 sm:grid-cols-3 gap-6">
            {features.map((f, i) => (
              <FeatureCard key={i} icon={f.icon} title={f.title} text={f.text} />
            ))}
          </div>
        </section>

        {/* Demo Panel Preview */}
        <section className="mt-16">
          <h3 className="text-xl font-semibold">Live Demo Preview</h3>
          <div className="mt-6">
            <DemoPanel />
          </div>
        </section>
      </div>
    </>
  )
}

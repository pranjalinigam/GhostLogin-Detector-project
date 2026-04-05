import React from 'react'
import FeatureCard from '../components/FeatureCard'
import RiskChart from '../components/RiskChart'

const featuresList = [
  {icon:'🔐', title:'Adaptive MFA', text:'Adjusts challenge strength based on risk.'},
  {icon:'🌍', title:'Geo intelligence', text:'Flags unusual country or city access.'},
  {icon:'🧠', title:'Behavior modelling', text:'Profiles typical device and time patterns.'},
  {icon:'📣', title:'Alerts & notifications', text:'Get real-time alerts for suspicious activity.'},
  {icon:'🔁', title:'Session controls', text:'Terminate risky sessions instantly.'},
  {icon:'📈', title:'Reporting', text:'Detailed risk and compliance reports.'}
]

export default function Features(){
  return (
    <div className="px-6 py-20">
      <h1 className="text-3xl font-bold">Features that make your accounts secure</h1>

      <section className="mt-8 grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
        {featuresList.map((f, i) => (
          <FeatureCard key={i} icon={f.icon} title={f.title} text={f.text} />
        ))}
      </section>

      <section className="mt-16">
        <h2 className="text-2xl font-semibold">Login Risk Levels</h2>
        <p className="mt-3 text-gray-600 max-w-2xl">Visual breakdown of login risk distribution. Use these levels to tune rules and alerts.</p>
        <div className="mt-8 max-w-md">
          <RiskChart />
        </div>
      </section>
    </div>
  )
}

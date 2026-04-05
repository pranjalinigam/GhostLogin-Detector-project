import React from 'react'

// Placeholder API integration point
async function fetchRecentLogins(){
  // Example: return fetch('/api/logins').then(r => r.json())
  return Promise.resolve([
    {id:1, ua:'Mobile', loc:'San Francisco, US', time:'2m ago', risk:'Low', status:'Approved'},
    {id:2, ua:'Desktop', loc:'Moscow, RU', time:'12m ago', risk:'High', status:'Suspicious'},
    {id:3, ua:'Mobile', loc:'Berlin, DE', time:'1h ago', risk:'Medium', status:'Denied'}
  ])
}

function Badge({status}){
  const cls = status === 'Approved' ? 'bg-green-100 text-green-800' : status === 'Denied' ? 'bg-red-100 text-red-800' : 'bg-yellow-100 text-yellow-800'
  return <span className={`px-2 py-1 rounded-full text-xs ${cls}`}>{status}</span>
}

export default function DemoPanel(){
  const [items, setItems] = React.useState([])

  React.useEffect(() => {
    let mounted = true
    fetchRecentLogins().then(data => { if(mounted) setItems(data) })
    return () => mounted = false
  }, [])

  return (
    <div className="bg-gradient-to-b from-white to-gray-50 p-6 rounded-2xl shadow-lg">
      <div className="flex items-center justify-between mb-4">
        <div>
          <div className="text-sm text-gray-500">Live Demo</div>
          <div className="text-lg font-semibold">Recent Login Events</div>
        </div>
        <div className="flex items-center gap-3">
          <button className="text-sm px-3 py-2 bg-white border rounded-full">Export</button>
          <button className="text-sm px-4 py-2 bg-gradient-to-r from-brand-500 to-accent text-white rounded-full">New Event</button>
        </div>
      </div>

      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
        {items.map(item => (
          <div key={item.id} className="p-4 bg-white rounded-lg shadow-sm">
            <div className="flex items-start justify-between">
              <div className="flex items-center gap-3">
                <div className="w-12 h-12 bg-gray-50 rounded-lg flex items-center justify-center text-2xl">{item.ua === 'Mobile' ? '📱' : '💻'}</div>
                <div>
                  <div className="font-semibold">{item.loc}</div>
                  <div className="text-xs text-gray-400">{item.time}</div>
                </div>
              </div>
              <div className="text-right">
                <div className="text-sm font-medium">Risk</div>
                <div className="mt-1">
                  <span className={`inline-block px-3 py-1 text-sm rounded-full ${item.risk === 'High' ? 'bg-red-100 text-red-700' : item.risk === 'Medium' ? 'bg-yellow-100 text-yellow-700' : 'bg-green-100 text-green-700'}`}>{item.risk}</span>
                </div>
                <div className="mt-3"><Badge status={item.status} /></div>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}

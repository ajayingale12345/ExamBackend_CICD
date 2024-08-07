const fs = require('fs');
const json2html = require('json2html');

// Load Trivy JSON report
const trivyReport = JSON.parse(fs.readFileSync('trivy-report.json', 'utf8'));

// Convert to HTML
const trivyReportHtml = json2html.render(trivyReport);

// Write HTML report to file
fs.writeFileSync('trivy-report.html', trivyReportHtml);

console.log('Trivy report converted to HTML successfully.');

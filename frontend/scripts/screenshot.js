#!/usr/bin/env node

/**
 * Take a screenshot of the map using Playwright
 */

import { chromium } from 'playwright';
import path from 'path';
import { fileURLToPath } from 'url';

const __dirname = path.dirname(fileURLToPath(import.meta.url));

async function takeScreenshot() {
	console.log('🎬 Launching browser...');

	const browser = await chromium.launch({
		headless: true
	});

	const context = await browser.newContext({
		viewport: { width: 1920, height: 1080 }
	});

	const page = await context.newPage();

	console.log('📍 Navigating to http://localhost:5173/...');

	try {
		await page.goto('http://localhost:5173/', {
			waitUntil: 'networkidle',
			timeout: 30000
		});

		console.log('⏳ Waiting for map to load...');

		// Wait for Leaflet map to be initialized
		await page.waitForSelector('.leaflet-container', { timeout: 10000 });

		// Wait a bit more for routes and stops to render
		await page.waitForTimeout(3000);

		const screenshotPath = path.join(__dirname, '..', 'map-screenshot.png');

		console.log('📸 Taking screenshot...');

		await page.screenshot({
			path: screenshotPath,
			fullPage: false
		});

		console.log(`✅ Screenshot saved to: ${screenshotPath}`);

		// Get console logs and errors
		const logs = await page.evaluate(() => {
			const logs = [];
			// Try to get console messages (they're already logged, just return empty for now)
			return logs;
		});

	} catch (error) {
		console.error('❌ Error:', error.message);

		// Try to take screenshot anyway
		try {
			const errorScreenshot = path.join(__dirname, '..', 'map-error-screenshot.png');
			await page.screenshot({ path: errorScreenshot });
			console.log(`📸 Error screenshot saved to: ${errorScreenshot}`);
		} catch (e) {
			// Ignore
		}
	} finally {
		await browser.close();
		console.log('✅ Browser closed');
	}
}

takeScreenshot();

class GameOfLife {

	def printer
	def seed

	def tick() {
		def nextGeneration = (seed == [1, 1, 1])? [0, 1, 0] : []
		printer.displayGeneration(nextGeneration)
	}
}

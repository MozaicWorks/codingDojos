import spock.lang.Specification
import spock.lang.Unroll

class GameOfLifeSpec extends Specification {

	def printer

	def setup() {
		printer = Mock(GameOfLifePrinter)
	}

	@Unroll
	def "#seed evolves in #nextGeneration when tick"() {
		given:
		def gameOfLife = new GameOfLife(printer: printer, seed: seed)

		when:
		gameOfLife.tick()

		then:
		1 * printer.displayGeneration(nextGeneration)

		where:
		seed      | nextGeneration
		[]        | []
		[1]       | []
		[1, 1]    | []
		[1, 1, 1] | [0, 1, 0]
	}
	@Unroll
	def "cell with #aliveStatus with #aliveNeighbours evolves in #nextAliveStatus cell when tick"() {
		given:
		def cell = new GameOfLifeCell(aliveStatus: aliveStatus, aliveNeighbours: aliveNeighbours, printer: printer)

		when:
		cell.tick()

		then:
		1 * printer.cellAliveStatus(nextAliveStatus)

		where:
		aliveStatus | aliveNeighbours | nextAliveStatus
		true        | 0               | false
		true        | 1               | false
	}
}

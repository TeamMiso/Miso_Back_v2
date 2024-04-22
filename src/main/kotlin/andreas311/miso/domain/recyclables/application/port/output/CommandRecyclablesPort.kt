package andreas311.miso.domain.recyclables.application.port.output

import andreas311.miso.domain.recyclables.domain.Recyclables

interface CommandRecyclablesPort {
    fun saveRecyclables(recyclables: Recyclables): Recyclables
    fun deleteRecyclables(recyclables: Recyclables)
}
package stub

import br.com.acalappv4.domain.entity.Hydrometer
import br.com.acalappv4.domain.entity.HydrometerCollect
import br.com.acalappv4.domain.entity.Reference
import io.azam.ulidj.ULID
import java.time.Month
import java.time.Year

val hydrometerCollectStub = HydrometerCollect(
    reference = Reference(
        year = Year.now(),
        Month.JANUARY,
    ),
    totalMeter = 11000
)

val hydrometerStub = Hydrometer(
    id = ULID.random(),
    actualCollect = hydrometerCollectStub,
    lastCollect = hydrometerCollectStub,
)

